
package Calculator.Calculator_2;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;





public class calculatorGUI extends JFrame {
    private JTextField displayField;

    public calculatorGUI(){
        setTitle("Simple Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,400);
        setLocationRelativeTo(null);

        initComponents();
    }
    private void initComponents(){

            displayField = new JTextField();
            displayField.setEditable(false);
            getContentPane().add(displayField, BorderLayout.NORTH);

            JPanel buttonsPanel = new JPanel(new GridLayout(4, 4));
            String[] buttonLabels ={
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        };

        for (String label: buttonLabels){
            JButton button = new JButton(label);
            button.addActionListener(new ButtonClickListener());
            buttonsPanel.add(button);
        }

        JButton resetButton = new JButton("C");
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayField.setText("");
            }
        });
        buttonsPanel.add(resetButton);

        getContentPane().add(buttonsPanel, BorderLayout.CENTER);

       
    }

        private class ButtonClickListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                String command = ((JButton) e.getSource()).getText();

                if (command.equals("=")) {
                    String expression  = displayField.getText();
                    try {

                        ScriptEngineManager manager = new ScriptEngineManager();
                    
                        ScriptEngine engine = manager.getEngineByName("JavaScript");

                        Object result = engine.eval(expression);

                        displayField.setText(result.toString());
                    } catch (ScriptException ex) {
                        
                    }

                } else {
                    displayField.setText(displayField.getText() + command); 


                }

                //displayField.setText(displayField.getText() + command);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new calculatorGUI().setVisible(true);
            }
        });
    }


}