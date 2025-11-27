package br.com.ifba.curso.view;

import br.com.ifba.curso.controller.CursoIController;
import br.com.ifba.curso.entity.Curso;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.RowFilter;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;


@Component
public class CursoListar extends javax.swing.JFrame {

    
    @Autowired
    private final CursoIController cursoController;

    @Autowired
    private CursoAdicionar telaAdicionar;
    
    @Autowired
    private CursoEditar telaEditar;

    private TableRowSorter<DefaultTableModel> sorter;

    @Autowired
    public CursoListar(CursoIController cursoController) {
        this.cursoController = cursoController;
        initComponents();

        // Configuração do Filtro e Tabela
        DefaultTableModel model = (DefaultTableModel) tblCurso.getModel();
        sorter = new TableRowSorter<>(model);
        tblCurso.setRowSorter(sorter);

        btnEditar.setEnabled(false);
        btnExcluir.setEnabled(false);

        adicionarListenerSelecaoTabela();
        adicionarFiltroListener();
        
    }

    @PostConstruct
    public void carregarDadosIniciais() {
        this.preencherTabela();
    }

    
    public void preencherTabela() {
        DefaultTableModel model = (DefaultTableModel) tblCurso.getModel();
        model.setRowCount(0);
        
        btnEditar.setEnabled(false);
        btnExcluir.setEnabled(false);

       
        
        try {
            List<Curso> cursos = cursoController.findAll();

            if (cursos != null) {
                for (Curso curso : cursos) {
                    model.addRow(new Object[]{
                        curso.getNome(), 
                        curso.getCodigoCurso() 
                    });
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao buscar cursos: " + e.getMessage());
        }
    }

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {
        
        telaAdicionar.setVisible(true);

        preencherTabela();
    }

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = tblCurso.getSelectedRow();
        if (selectedRow == -1) return;

        int modelRow = tblCurso.convertRowIndexToModel(selectedRow);
        String codigoCurso = (String) tblCurso.getModel().getValueAt(modelRow, 1);

        try {
            
             Curso cursoParaEditar = cursoController.findByCodigo(codigoCurso); 
            
            if(cursoParaEditar != null){
                
                telaEditar.prepararEdicao(cursoParaEditar);
                
                telaEditar.setVisible(true);
                
                preencherTabela();
            }
             

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage());
        }
    }

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = tblCurso.getSelectedRow();
        if (selectedRow == -1) return;

        int modelRow = tblCurso.convertRowIndexToModel(selectedRow);
        String codigoCurso = (String) tblCurso.getModel().getValueAt(modelRow, 1);
        String nomeCurso = (String) tblCurso.getModel().getValueAt(modelRow, 0);

        int confirm = JOptionPane.showConfirmDialog(this, 
                "Excluir: " + nomeCurso + "?", "Confirmar", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
               
                
                
                Curso curso = cursoController.findByCodigo(codigoCurso);
                
                if(curso != null){
                    cursoController.delete(curso);
                    JOptionPane.showMessageDialog(this, "Excluído com sucesso!");
                    preencherTabela();
                } else {
                    
                }             
               
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erro ao excluir: " + e.getMessage());
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtPesquisar = new javax.swing.JTextPane();
        btnAdicionar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCurso = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(20, 51, 72));

        txtPesquisar.setToolTipText("Pesquisar Curso");
        jScrollPane1.setViewportView(txtPesquisar);

        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        tblCurso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Nome", "Codigo do Curso"
            }
        ));
        jScrollPane2.setViewportView(tblCurso);

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAdicionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAdicionar)
                        .addComponent(btnEditar)
                        .addComponent(btnExcluir))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        


    private void adicionarListenerSelecaoTabela() {
        tblCurso.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    if (tblCurso.getSelectedRow() != -1) {
                        btnEditar.setEnabled(true);
                        btnExcluir.setEnabled(true);
                    } else {
                        btnEditar.setEnabled(false);
                        btnExcluir.setEnabled(false);
                    }
                }
            }
        });
    }

    private void adicionarFiltroListener() {
        txtPesquisar.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) { filtrar(); }
            @Override
            public void removeUpdate(DocumentEvent e) { filtrar(); }
            @Override
            public void changedUpdate(DocumentEvent e) {}
        });
    }


    private void filtrar() {
        String texto = txtPesquisar.getText();
        if (texto.trim().length() == 0) {
            sorter.setRowFilter(null);
        } else {
            try {
                sorter.setRowFilter(RowFilter.regexFilter("(?i)" + texto, 0, 1));
            } catch (java.util.regex.PatternSyntaxException e) {
            }
        }
    }
    
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblCurso;
    private javax.swing.JTextPane txtPesquisar;
}