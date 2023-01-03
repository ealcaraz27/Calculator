import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener{  
    static JFrame p = new JFrame("Calculator");
    static JTextField r = new JTextField(20);
    String s0,s1,s2;
    Calculator(){
        s0 = s1 = s2 = "";
    }
    public void actionPerformed(ActionEvent e){
        String s = e.getActionCommand();
        if((s.charAt(0) >= '0' && s.charAt(0) <= '9' || s.charAt(0) == '.')){
            if(!s1.equals(""))
                s2 = s2 + s;
            else
                s0 = s0 + s;
            r.setText(s0 + s1 + s2);
        }
        else if(s.charAt(0) == 'C'){
            s0 = s1 = s2 = "";
            r.setText(s0 + s1 + s2);
        }
        else if(s.charAt(0) == '='){
            double t;
            if(s1.equals("+"))
                t = (Double.parseDouble(s0) + Double.parseDouble(s2));
            else if(s1.equals("-"))
                t = (Double.parseDouble(s0) - Double.parseDouble(s2));
            else if(s1.equals("/"))
                t = (Double.parseDouble(s0) / Double.parseDouble(s2));
            else
                t = (Double.parseDouble(s0) * Double.parseDouble(s2));
            r.setText(s0 + s1 + s2 + "=" + t);
            s0 = Double.toString(t);
            s1 = s2 = "";
        }
        else{
            if(s1.equals("") || s2.equals(""))
                s1 = s;
            else{
                double t;
                if(s1.equals("+"))
                    t = (Double.parseDouble(s0) + Double.parseDouble(s2));
                else if(s1.equals("-"))
                    t = (Double.parseDouble(s0) - Double.parseDouble(s2));
                else if(s1.equals("/"))
                    t = (Double.parseDouble(s0) / Double.parseDouble(s2));
                else
                    t = (Double.parseDouble(s0) * Double.parseDouble(s2));
                s0 = Double.toString(t);
                s1 = s;
                s2 = "";
            }
            r.setText(s0 + s1 + s2);
        }
    }
    public static void main(String args[]){
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
        JButton zero, one, two, three, four, five, six, seven, eight, nine, plus, minus, div, mult, clear, eq, dec;
        zero = new JButton("0");
        one = new JButton("1");
        two = new JButton("2");
        three = new JButton("3");
        four = new JButton("4");
        five = new JButton("5");
        six = new JButton("6");
        seven = new JButton("7");
        eight = new JButton("8");
        nine = new JButton("9");
        plus = new JButton("+");
        minus = new JButton("-");
        div = new JButton("/");
        mult = new JButton("*");
        clear = new JButton("Clear");
        eq = new JButton("=");
        dec = new JButton(".");

        Calculator c = new Calculator();
        JPanel pan = new JPanel();

        zero.addActionListener(c);
        one.addActionListener(c);
        two.addActionListener(c);
        three.addActionListener(c);
        four.addActionListener(c);
        five.addActionListener(c);
        six.addActionListener(c);
        seven.addActionListener(c);
        eight.addActionListener(c);
        nine.addActionListener(c);
        plus.addActionListener(c);
        minus.addActionListener(c);
        div.addActionListener(c);
        mult.addActionListener(c);
        clear.addActionListener(c);
        eq.addActionListener(c);
        dec.addActionListener(c);

        r.setEditable(false);
        pan.add(r);
        pan.add(zero);
        pan.add(one);
        pan.add(two);
        pan.add(three);
        pan.add(four);
        pan.add(five);
        pan.add(six);
        pan.add(seven);
        pan.add(eight);
        pan.add(nine);
        pan.add(plus);
        pan.add(minus);
        pan.add(div);
        pan.add(mult);
        pan.add(clear);
        pan.add(eq);
        pan.add(dec);

        pan.setBackground(Color.white);
        p.add(pan);
        p.setSize(400,400);
        p.setVisible(true);
    }
}
