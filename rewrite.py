import os, os.path
from playsound import playsound
import random
from random import randint
random.random
import threading
import time


def loadPath(rootPath):
    noteFileNames = os.listdir(rootPath)
    notePaths = []

    for noteFileName in noteFileNames:
        fullPath = os.path.join(rootPath, noteFileName)
        notePaths.append(fullPath)

    return notePaths

notePaths = loadPath("D:/Stuff/Programming/TYP/Personal-Code/MusicFiles/A Natural Minor Scale")
chordPaths = loadPath("D:/Stuff/Programming/TYP/Personal-Code/MusicFiles/Chords")

def playSound(path, x):
    playsound(path, x)

#Producer of notes and chords
currentChord, currentNote, checkChord = 0,0,0

def nextChord(chordPaths):
    global currentChord, checkChord
    checkChord += 1

    if (checkChord % 4 == 0):
        currentChord += 1
        if(currentChord == len(chordPaths)):
            currentChord = 0
    print("========")
    print(chordPaths[currentChord].split("\\")[1])
    return chordPaths[currentChord]

def nextNote(notePaths):
    global currentNote
    if (currentNote == len(notePaths) & 16):
        currentNote = 0
    else:
        currentNote += 1
        # currentNote = random.randint(0,16)
        print(notePaths[currentNote].split("\\")[1])
        print("========")
    return notePaths[currentNote]
    
def noteSequencer(currentNote, currentPattern):
    
    patternMap = {
        "0": [4,6,4,9,7],
        "1": [3,5,7,8,9,11,10,9]
        # More patterns to be made later etc.
    }
    
    while True:
        if (currentPattern >=len(patternMap[str(currentNote)])):
            if(currentNote == 2):
                currentNote = "0"
                print("Starting Pattern One...")
                currentPattern = 0
            elif (currentNote == 3):
                currentNote = "1"
                currentPattern = 0
                print("Starting Pattern Two...")
            else:
                currentPattern += 1
                currentPattern = 0
                print("Switching back to Note", currentNote) 
                
            return currentNote, currentPattern


def consumer():
    #Also acquiring set of notes to be then played  
    global notePaths
    currentChord,currentPattern,currentNote = 0,0
    #Keeps track of the current chord and note being played
    currentNotePath = notePaths[currentNote]
    currentChordPath = chordPaths[currentChord] 
    
    #Play the notes at a time
    while True:
        currentNotePath = nextNote(notePaths) #Allows for next note progression
        currentPattern = noteSequencer(currentNotePath) #Then utilise the noteSequencer for patterns.
        #Have some sort set of rules/random generation.
        time.sleep(5)
        yield currentPattern
 
    #Updating what the current note and chord is and sends the results to play() function below.
   
def play():
    while True:
        chord = nextChord(chordPaths)
        note = consumer()
        playSound(chord, False)
        playSound(note)        
play()

