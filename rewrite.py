import os, os.path
from playsound import playsound
import random
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
def noteOrder(notePaths):
    pass

currentChord = 0
currentPattern = 0
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

    return chordPaths[currentChord]

def nextNote(notePaths):
    global currentNote
    if (currentNote == len(notePaths) & 16):
        currentNote = 0
    else:
        currentNote += 1
        # currentNote = random.randint(0,16)
        print(notePaths[currentNote].split("\\")[1])
    return notePaths[currentNote]
    
def patternGenerator(currentNote):
    global currentPattern
    patternOne = (4,6,4,9,7)
    patternTwo = (3,5,7,8,9,11,10,9)

    if (currentPattern >=len(currentNote)):
        if(currentNote == 2):
            currentNote = patternOne
            print("Starting Pattern One...")
            currentPattern = 0
        elif (currentNote == 3):
            currentNote = patternTwo
            currentPattern = 0
            print("Starting Pattern Two...")
        else:
            currentPattern += 1
            print("In Pattern ", currentPattern) 
            return currentPattern

def consumer():
    #Consumer - continously looping waits for chords and notes to play (await.function() ?)
    #the consumer function would intake from the note pattern generator
    #keeps track of where it is(state) within the harmonic and melodic sections ?
    #Should make notes for A TIME.
    
    pass

def play():
    while True:
        chord = nextChord(chordPaths)
        note = nextNote(notePaths)
        playSound(chord, False)
        playsound(note)

play()
