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

currentChord = 0
currentNote = 0
checkChord = 0
# checkNote = 0 This maybe useful for later

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
    
def noteSequencer(currentNote):
    
    patternMap = {
        "patternOne": [4,6,4,9,7],
        "patternTwo": [3,5,7,8,9,11,10,9]
        # More patterns to be made later etc.
    }
    
    while True:
        if (currentPattern >=len(patternMap[str(currentNote)])):
            if(currentNote == 2):
                currentNote = patternMap["patternOne"]
                print("Starting Pattern One...")
                currentPattern = 0
            elif (currentNote == 3):
                currentNote = patternMap=["patternTwo"]
                currentPattern = 0
                print("Starting Pattern Two...")
            else:
                currentPattern += 1
                currentPattern = 0
                print("Switching back to Note", currentNote) 
                
            return currentPattern, currentNote


    #Consumer function - continously looping waits for chords and notes to play
    #- The consumer function would intake from the note pattern generator
    #- Keeps track of where it is(state) within the melodic and harmonic sections
    #- Should make notes for A TIME.
    #   * Could utilise threading and time imports for this.

def consumer():
    #Also acquiring set of notes to be then played  
    global currentNote, currentChord, notePaths
    
    #Keeps track of the current chord and note being played
    currentNotePath = notePaths[currentNote]
    currentChordPath = chordPaths[currentChord]
    
    #Play the notes at a time
    while True:
        currentNotePath = nextNote(notePaths) #Allows for next note progression
        currentPattern = noteSequencer(currentNotePath) #based off the previous note, it will utilise the noteSequencer for patterns.
        time.sleep(5)
        
    #Determines what next note should be played
    #Have some sort set of rules/random generation, can be borrowed from the noteSequencer() function 
    
    #Updating what the current note and chord is and sends the results to play() function below.
   
    return currentNotePath, currentPattern

def play():
    while True:
        chord = nextChord(chordPaths)
        note = nextNote(notePaths)
        playSound(chord, False)
        playSound(note)
        
play()
