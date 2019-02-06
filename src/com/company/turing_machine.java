package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class turing_machine {

    Scanner input = new Scanner(System.in);
    int num_of_trans;
    public ArrayList<trans> transition = new ArrayList<>();
    int currentstate , nextstate;
    char currentinput , nextinput , dir_action;
    int head;
    String tape;
    int length;
    int start;
    String final_tape="";

    public turing_machine(){

        System.out.print("Enter number of states = ");
        int num_of_states = input.nextInt();
        System.out.print("Enter number of Alphabet = ");
        int num_of_alph = input.nextInt();
        num_of_trans = num_of_states * num_of_alph;
        //System.out.println("number of transitions " + num_of_trans);

        System.out.println("Enter Transition function ");
        addTrans();

        System.out.print("Enter start state ");
        start = input.nextInt();

        System.out.print("Enter input String ");
        tape = input.next();
        length = tape.length();

        System.out.print("Enter head position ");
        head = input.nextInt();
        System.out.println("initial configuration : (" + start + "," + tape + "," + tape.charAt(head) + ")");

    }

    public void addTrans(){

        for(int i=0;i<num_of_trans;i++){
            currentstate = input.nextInt();
            currentinput = input.next().charAt(0);
            nextstate = input.nextInt();
            nextinput = input.next().charAt(0);
            dir_action = input.next().charAt(0);

            trans add = new trans(currentstate,currentinput,nextstate,nextinput,dir_action);
            transition.add(add);
        }
    }

    public void Action_set(char action, int currentstate, int nextstate){

        currentstate = nextstate;
        start = currentstate;

        if(action == 'r' || action == 'R'){
            head = head + 1;
            if(head==length){
                tape = tape + '#';
                length++;
            }
        }

        else if(action == 'l' || action == 'L'){
            head = head - 1;
            if (head<0){
                head = 0;
            }
        }

        else if(action == 'y' || action == 'Y'){
            System.out.println("final configuration : ("+ currentstate + "," + final_tape + "," + tape.charAt(head) + ")");
            System.out.println("accept");
        }

        else if(action == 'n' || action == 'N'){
            System.out.println("final configuration : ("+ currentstate + "," + final_tape + "," + tape.charAt(head) + ")");
            System.out.println("reject");
        }

        //System.out.println("configuration : (" + currentstate + "," + tape + "," + tape.charAt(head) + ")");


    }

    public void Tape(){

        for (int i=0;i<length;i++){
            if (tape.contains("<")){
                if (!tape.startsWith("<")){
                    System.out.println("WRONG INPUT");
                    break;
                }
            }

            for (trans add:transition){
                if (add.current_state == start && add.current_input == tape.charAt(head)){
                    final_tape = final_tape + add.new_symbol;
                    //System.out.println("tape "+ final_tape);
                    Action_set(add.action,add.current_state,add.new_state);
                    break;
                }
            }
        }
    }

    public static void main(String[] args){

        turing_machine TM = new turing_machine();
        TM.Tape();

    }

}
