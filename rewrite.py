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

def playSound(path):
    playsound(path)

#Producer of notes and chords
def noteOrder(notePaths):
    pass

currentChord = 0
checkChord = 0
currentNote = 0

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
    

def threadFunction():
    pass

def play():
    while True:
            chord = nextChord(chordPaths)
            note = nextNote(notePaths)
            playSound(chord, False)
            playSound(note)
play()

#Consumer - continously looping waits for chords and notes to play (await.function())
#Later on: note pattern generator, keeps track of where it is(state) within the harmonic section
