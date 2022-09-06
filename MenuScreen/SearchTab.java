package MenuScreen;


import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.event.*;
import javax.swing.table.*;

public class SearchTab extends JPanel {

    SearchTab() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        try {
            ReadWrite.getInstance("Java\\MenuScreen\\data.ser");
            ReadWrite.getInstance("").readStatic();
            JTabbedPane tabs = new JTabbedPane();
            JTable defuntosTable = new JTable(ReadWrite.getInstance("").defuntosAbsTable);
            JTable funcionariosTable = new JTable(ReadWrite.getInstance("").funcionariosAbsTable);
            JTable familiaresTable = new JTable(ReadWrite.getInstance("").familiaresAbsTable);
            SearchFilterTable defuntosSFT = new SearchFilterTable(defuntosTable);
            SearchFilterTable familiaresSFT = new SearchFilterTable(familiaresTable);
            SearchFilterTable funcionariosSFT = new SearchFilterTable(funcionariosTable);
            tabs.addTab("Defuntos", defuntosSFT);
            tabs.addTab("Funcionarios", funcionariosSFT);
            tabs.addTab("Familiares", familiaresSFT);
            add(tabs);
        } catch (Exception e) {
            JLabel errorMsg = new JLabel("Erro ao carregar arquivo!");
            errorMsg.setFont(new FontUIResource("Arial", Font.BOLD, 20));
            errorMsg.setForeground(Color.red);
            add(errorMsg);
        }
    }

    public class SearchFilterTable extends JPanel {

        public SearchFilterTable(JTable table) {
            setLayout(new BorderLayout());
            TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
            JTextField searchBar = new JTextField();
            table.setRowSorter(sorter);
            add(searchBar, BorderLayout.NORTH);
            add(new JScrollPane(table), BorderLayout.CENTER);
            searchBar.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    String str = searchBar.getText();
                    if (str.trim().length() == 0) {
                        sorter.setRowFilter(null);
                    } else {
                        // (?i) means case insensitive search
                        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + str));
                    }
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    String str = searchBar.getText();
                    if (str.trim().length() == 0) {
                        sorter.setRowFilter(null);
                    } else {
                        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + str));
                    }
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                }
            });
            table.setDefaultEditor(Object.class, null);
        }
    }
}
