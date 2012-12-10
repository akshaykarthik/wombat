# Game.py
import pygame
from pygame.locals import *
from State import StateManager


class Game(object):
    """docstring for Game"""
    def __init__(self,
            name,
            screen_size=(1024, 768),
            fps=240,
            clock=None,
            screen=None):

        super(Game, self).__init__()
        self.name = name
        self.screen_size = screen_size
        self.fps = fps

        pygame.init()
        pygame.display.set_caption(name)

        self.clock = clock or pygame.time.Clock()
        self.screen = screen or pygame.display.set_mode(screen_size)
        self.sm = StateManager()
        self.background_color = (0, 0, 0)
        self.current_state = None

    def setup(self):
        pass

    def preupdate(self):
        self.clock.tick(self.fps)
        self.dt = self.clock.get_time() * 0.001

    def update(self):
        self.sm.update(self.dt)

    def postupdate(self):
        pass

    def draw(self):
        self.sm.draw(self.screen)

    def predraw(self):
        self.screen.fill(self.background_color)

    def postdraw(self):
        pygame.display.flip()
