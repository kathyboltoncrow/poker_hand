package com.techreturners.enums;

public enum Suit {
    CLUBS {
        @Override
        public char toChar() {
            return 'C';
        }
    },
    SPADES {
        @Override
        public char toChar() {
            return 'S';
        }
    },
    HEARTS {
        @Override
        public char toChar() {
            return 'H';
        }
    },
    DIAMONDS {
        @Override
        public char toChar() {
            return 'D';
        }
    };

    public char toChar() {
        return 'X';
    }
}

