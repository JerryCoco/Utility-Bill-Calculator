import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UtilityBillCalculator extends JFrame {

    private JTextField txtGallons = new JTextField(10);
    private JTextField txtKilowatts = new JTextField(10);

    private JLabel lblWaterBill = new JLabel("0.00");
    private JLabel lblElectricityBill = new JLabel("0.00");
    private JLabel lblTotalBill = new JLabel("0.00");

    public UtilityBillCalculator() {
        setTitle("PURC Utility Bill Calculator");
        setSize(400, 300);
        setLayout(new BorderLayout());

        // Input Section
        JPanel inputPanel = new JPanel(new GridLayout(2, 2));
        inputPanel.add(new JLabel("Water Used (gallons):"));
        inputPanel.add(txtGallons);
        inputPanel.add(new JLabel("Electricity Used (kWh):"));
        inputPanel.add(txtKilowatts);

        // Output Section (Results)
        JPanel outputPanel = new JPanel(new GridLayout(3, 2));
        outputPanel.setBorder(BorderFactory.createTitledBorder("Results"));
        outputPanel.add(new JLabel("Water Bill:"));
        outputPanel.add(lblWaterBill);
        outputPanel.add(new JLabel("Electricity Bill:"));
        outputPanel.add(lblElectricityBill);
        outputPanel.add(new JLabel("Total Bill:"));
        outputPanel.add(lblTotalBill);

        // Buttons
        JPanel buttonPanel = new JPanel();
        JButton btnCalculate = new JButton("Calculate");
        JButton btnNew = new JButton("New");
        JButton btnExit = new JButton("Exit");
        buttonPanel.add(btnCalculate);
        buttonPanel.add(btnNew);
        buttonPanel.add(btnExit);

        add(inputPanel, BorderLayout.NORTH);
        add(outputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Action Listeners
        btnCalculate.addActionListener(e -> calculateBill());
        btnNew.addActionListener(e -> saveToDatabase());
        btnExit.addActionListener(e -> exitApp());

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void calculateBill() {
        try {
            double gallons = Double.parseDouble(txtGallons.getText());
            double kilowatts = Double.parseDouble(txtKilowatts.getText());

            double waterBill = (gallons > 500) ? (gallons - 500) * 1.05 : 0;

            double elecBill = 0;
            if (kilowatts > 150) {
                elecBill = (100 * 0.5) + ((kilowatts - 150) * 1.20);
            } else if (kilowatts > 50) {
                elecBill = (kilowatts - 50) * 0.5;
            }

            double total = waterBill + elecBill;

            lblWaterBill.setText(String.format("%.2f", waterBill));
            lblElectricityBill.setText(String.format("%.2f", elecBill));
            lblTotalBill.setText(String.format("%.2f", total));

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers.");
        }
    }

    private void saveToDatabase() {
        // Simulated save
        String msg = "Saved:\nWater Bill: " + lblWaterBill.getText()
                   + "\nElectricity Bill: " + lblElectricityBill.getText()
                   + "\nTotal Bill: " + lblTotalBill.getText();
        JOptionPane.showMessageDialog(this, msg);
    }

    private void exitApp() {
        int confirm = JOptionPane.showConfirmDialog(this, "Do you want to exit?", "Confirm Exit", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new UtilityBillCalculator().setVisible(true));
    }
}