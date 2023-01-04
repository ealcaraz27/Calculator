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
        pan.setLayout(new BoxLayout(pan,BoxLayout.PAGE_AXIS));
        JPanel r1 = new JPanel();
        JPanel r2 = new JPanel();
        JPanel r3 = new JPanel();
        JPanel r4 = new JPanel();
        JPanel r5 = new JPanel();
        r1.setLayout(new BoxLayout(r1, BoxLayout.LINE_AXIS));
        r2.setLayout(new BoxLayout(r2, BoxLayout.LINE_AXIS));
        r3.setLayout(new BoxLayout(r3, BoxLayout.LINE_AXIS));
        r4.setLayout(new BoxLayout(r4, BoxLayout.LINE_AXIS));
        r5.setLayout(new BoxLayout(r5, BoxLayout.LINE_AXIS));
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
        r1.add(Box.createHorizontalGlue());
        r1.add(clear);

        r2.add(seven);
        r2.add(eight);
        r2.add(nine);
        r2.add(div);

        r3.add(four);
        r3.add(five);
        r3.add(six);
        r3.add(mult);

        r4.add(one);
        r4.add(two);
        r4.add(three);
        r4.add(minus);

        r5.add(zero);
        r5.add(dec);
        r5.add(plus);
        r5.add(eq);

        pan.setBackground(Color.PINK);
        pan.add(r1);
        pan.add(r2);
        pan.add(r3);
        pan.add(r4);
        pan.add(r5);
        p.add(pan);
        p.setSize(300,300);
        p.setVisible(true);
    }
}
