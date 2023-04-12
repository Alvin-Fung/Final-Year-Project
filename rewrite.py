import os
import sys
import pygame 
from pygame import *

#A function to load notes
# notepath = "/Users/TopNo/Desktop/Rewrite/audioFiles/A Natural Minor Scale"
notePath = os.listdir("C:/Users/TopNo/Desktop/Rewrite/audioFiles/A Natural Minor Scale")
print(notePath)

#A function to load chords
chordPath = os.listdir("C:/Users/TopNo/Desktop/Rewrite/audioFiles/Harmonic chords")
print(chordPath)

#Producer of notes and chords

pygame.init()


#Consumer - continously looping waits for chords and notes to play

#Later on: note pattern generator, keeps track of where it is(state) within the harmonic section
