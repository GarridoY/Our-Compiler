package dk.aau.cs.d703e20;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenSource;

// Class to create tokens outside lexer to test parser without depending on lexer
// Only methods getText and getType are used
public class TestToken implements Token {
    String text;
    int type;

    public TestToken(String text, int type) {
        this.text = text;
        this.type = type;
    }

    @Override
    public String getText() {
        return text;
    }


    @Override
    public int getType() {
        return type;
    }

    @Override
    public int getLine() {
        return 0;
    }

    @Override
    public int getCharPositionInLine() {
        return 0;
    }

    @Override
    public int getChannel() {
        return 0;
    }


    @Override
    public int getTokenIndex() {
        return 0;
    }

    @Override
    public int getStartIndex() {
        return 0;
    }

    @Override
    public int getStopIndex() {
        return 0;
    }

    @Override
    public TokenSource getTokenSource() {
        return null;
    }

    @Override
    public CharStream getInputStream() {
        return null;
    }
}

