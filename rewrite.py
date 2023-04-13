import os, os.path
import numpy as np
from playsound import playsound

notePath = os.listdir("D:/Stuff/Programming/TYP/Personal-Code/MusicFiles/A Natural Minor Scale")
notesArray = np.array(notePath)
print("Notes: ", notesArray)

chordPath = os.listdir("D:/Stuff/Programming/TYP/Personal-Code/MusicFiles/Chords")
chordArray = np.array(chordPath)
print("Chords: ",chordArray)

playsound('D:/Stuff/Programming/TYP/Personal-Code/MusicFiles/Chords/CMaj7.mp3')

#Producer of notes and chords

#Consumer - continously looping waits for chords and notes to play

#Later on: note pattern generator, keeps track of where it is(state) within the harmonic section
