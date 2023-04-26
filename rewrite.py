import os, os.path
from playsound import playsound
import random
from random import randint
random.random
import threading
import time

def playSound(path, x):
    playsound(path, x)

def loadPath(rootPath):
    noteFileNames = os.listdir(rootPath)
    notePaths = []

    for noteFileName in noteFileNames:
        fullPath = os.path.join(rootPath, noteFileName)
        notePaths.append(fullPath)

    return notePaths

notePaths = loadPath("D:/Stuff/Programming/TYP/Personal-Code/MusicFiles/A Natural Minor Scale")
chordPaths = loadPath("D:/Stuff/Programming/TYP/Personal-Code/MusicFiles/Chords")

#Producer of notes and chords
patternMap = {
        "0": [4,6,4,9,7],
        "1": [3,5,7,8,9,11,10,9]
        # More patterns to be made later etc.
    }
currentChord, currentNote, currentPattern, checkChord = 0,0,0,0

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

def nextNote(notePaths, patternMap):
    global currentNote,currentPattern
    
    while True:
            if (currentPattern >=len(str(currentNote))):
                if(currentNote == 2):
                    currentNote = patternMap["0"]
                    print("Starting Pattern One...")
                    currentPattern = 0
                elif (currentNote == 3):
                    currentNote = patternMap["1"]
                    currentPattern = 0
                    print("Starting Pattern Two...")
                else:
                    currentPattern += 1
                    print("Switching back to Note", currentNote) 
                    
                    return currentPattern

            if (currentNote == len(notePaths) & 16):
                currentNote = 0
            else:
                currentNote += 1
                currentNote = random.randint(0,16)
                print(notePaths[currentNote].split("\\")[1])
                print("========")
                return notePaths[currentNote]

def play():
    while True:
        #Have conversion from index position to an actual note here
        chord = nextChord(chordPaths)
        note = nextNote(notePaths, patternMap)
        playSound(chord, False)
        playSound(note, True)        
play()
