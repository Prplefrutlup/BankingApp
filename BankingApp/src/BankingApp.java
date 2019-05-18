import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class BankingApp extends JFrame implements ActionListener {
    private JPanel BankPanel;
    private JButton getBalanceButton;
    private JButton depositButton;
    private JButton withDrawButton;
    private JFormattedTextField balanceFormattedText;
    private JFormattedTextField depositFormattedText;
    private JFormattedTextField withdrawFormattedText;
    private JLabel balanceLabel;
    private JLabel depositLabel;
    private JLabel withdrawLabel;
    private double balance;

    public BankingApp() {

        GridBagConstraints layoutConst;

        // This is the main panel for the app
        setTitle("Banking App");
        setSize(1000, 1000);

        // sets labels
        balanceLabel = new JLabel("Enter Account Balance: ");
        depositLabel = new JLabel("Enter amount to deposit: ");
        withdrawLabel = new JLabel("Enter amount to withdraw: ");

        // sets buttons and gives them actions
        getBalanceButton = new JButton("Get Balance");
        getBalanceButton.addActionListener(this);

        depositButton = new JButton("Deposit Funds");
        depositButton.addActionListener(this);

        withDrawButton = new JButton("Withdraw Funds");
        withDrawButton.addActionListener(this);

        // creates formatted text fields
        balanceFormattedText = new JFormattedTextField(NumberFormat.getIntegerInstance());
        balanceFormattedText.setEditable(true);
        balanceFormattedText.setColumns(15);

        depositFormattedText = new JFormattedTextField((NumberFormat.getIntegerInstance()));
        depositFormattedText.setEditable(true);
        depositFormattedText.setColumns(15);

        withdrawFormattedText = new JFormattedTextField(NumberFormat.getIntegerInstance());
        withdrawFormattedText.setEditable(true);
        withdrawFormattedText.setColumns(15);

        // creates new layout for labels, buttons and text fields
        setLayout(new GridBagLayout());

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(0, 0, 0, 0);
        layoutConst.gridx = 0;
        layoutConst.gridy = 0;
        add(balanceLabel, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(0, 0, 0, 1);
        layoutConst.gridx = 0;
        layoutConst.gridy = 1;
        add(balanceFormattedText, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(0, 0, 0, 5);
        layoutConst.gridx = 0;
        layoutConst.gridy = 2;
        add(getBalanceButton, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(0, 0, 0, 0);
        layoutConst.gridx = 1;
        layoutConst.gridy = 0;
        add(depositLabel, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(0, 0, 0, 1);
        layoutConst.gridx = 1;
        layoutConst.gridy = 1;
        add(depositFormattedText, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(0, 0, 0, 5);
        layoutConst.gridx = 1;
        layoutConst.gridy = 2;
        add(depositButton, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(0, 0, 0, 0);
        layoutConst.gridx = 2;
        layoutConst.gridy = 0;
        add(withdrawLabel, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(0, 0, 0, 1);
        layoutConst.gridx = 2;
        layoutConst.gridy = 1;
        add(withdrawFormattedText, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(0, 0, 0, 5);
        layoutConst.gridx = 2;
        layoutConst.gridy = 2;
        add(withDrawButton, layoutConst);

        WindowListener wndCloser = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                JOptionPane.showMessageDialog(null,
                        "Account Balance: $" + ((Number) balanceFormattedText.getValue()).doubleValue());
                System.exit(0);
            }
        };

        addWindowListener(wndCloser);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent event) {
        balance = ((Number) balanceFormattedText.getValue()).doubleValue(); // sets balance equal to the amount entered
                                                                            // into balance text field

        JButton sourceEvent = (JButton) event.getSource();

        if (sourceEvent == getBalanceButton) {
            balance = ((Number) balanceFormattedText.getValue()).doubleValue(); // sets balance equal to the amount
                                                                                // entered into balance text field
            JOptionPane.showMessageDialog(this, "Account Balance: $" + balance);
        } else if (sourceEvent == depositButton) {
            balance += ((Number) depositFormattedText.getValue()).doubleValue(); // takes deposited amount and adds it
                                                                                 // to the balance
            JOptionPane.showMessageDialog(this, "Balance after deposit: $" + balance); // shows balance after deposit
            balanceFormattedText.setValue(balance); // sets new balance to balance field
        } else if (sourceEvent == withDrawButton) {
            balance -= ((Number) withdrawFormattedText.getValue()).doubleValue(); // subtracts withdraw amount from
                                                                                  // balance
            JOptionPane.showMessageDialog(this, "Balance after withdraw: $" + balance); // shows balance after withdraw
            balanceFormattedText.setValue(balance); // sets new balance to balance field
        }
    }

}
