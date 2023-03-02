package com.techreturners.enums;

public enum Rank {
    TWO {
        @Override
        public char toChar() {
            return '2';
        }
    },
    THREE{
        @Override
        public char toChar() {
            return '3';
        }
    },
    FOUR {
        @Override
        public char toChar() {
            return '4';
        }
    },
    FIVE {
        @Override
        public char toChar() {
            return '5';
        }
    },
    SIX {
        @Override
        public char toChar() {
            return '6';
        }
    },
    SEVEN {
        @Override
        public char toChar() {
            return '7';
        }
    },
    EIGHT {
        @Override
        public char toChar() {
            return '8';
        }
    },NINE {
        @Override
        public char toChar() {
            return '9';
        }
    },TEN {
        @Override
        public char toChar() {
            return 'T';
        }
    },JACK {
        @Override
        public char toChar() {
            return 'J';
        }
    },QUEEN {
        @Override
        public char toChar() {
            return 'Q';
        }
    },KING {
        @Override
        public char toChar() {
            return 'K';
        }
    },ACE {
        @Override
        public char toChar() {
            return 'A';
        }
    };


    public char toChar() {
        return 'X';
    }
}


