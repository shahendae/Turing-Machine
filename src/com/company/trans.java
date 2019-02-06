package com.company;


public class trans {

    public int current_state, new_state;
    public char current_input, new_symbol, action;


    public trans(int current_state, char current_input, int new_state, char new_symbol, char action ) {

        this.current_state = current_state;
        this.current_input = current_input;
        this.new_state = new_state;
        this.new_symbol = new_symbol;
        this.action = action;

    }
}
