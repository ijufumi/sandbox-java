package t.a.n001;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TableWindow extends JFrame {

    private static final String[] COLUMN_NAMES = {"ID", "NAME", "SEX"};
    private static final String[][] INITIAL_DATA = {{"1", "John", "Male"}, {"2", "Lisa", "Female"}};

    public TableWindow() {
        setTitle("Test");
        setSize(new Dimension(400, 200));

        JPanel mainPanel = new JPanel(new FlowLayout());
        DefaultTableModel tableModel = new DefaultTableModel(INITIAL_DATA, COLUMN_NAMES);
        tableModel.addTableModelListener(e -> {
            if (e.getType() == TableModelEvent.INSERT) {
                insertRecord();
            }
            else if (e.getType() == TableModelEvent.UPDATE) {
                updateRecord();
            }
        });

        JTable table = new JTable(tableModel);
        mainPanel.add(table);

        JButton insertButton = new JButton("Add");
        insertButton.addActionListener(e -> {
            // ここで画面などを使い、登録するデータを入力させる

            // 入力した値を元に行を追加する
            tableModel.addRow(new Object[]{});
        });
        mainPanel.add(insertButton);

        getContentPane().add(mainPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void insertRecord() {
        System.out.println("insert");
    }

    private void updateRecord() {
        System.out.println("update");
    }
}
