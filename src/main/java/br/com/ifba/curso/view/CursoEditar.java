/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.ifba.curso.view;


import br.com.ifba.curso.controller.CursoIController;
import br.com.ifba.curso.entity.Curso; // Importa a Entidade (o "molde" dos dados).
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CursoEditar extends javax.swing.JDialog {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(CursoEditar.class.getName());

    @Autowired
    private CursoIController cursoController;
    private Curso cursoParaEditar;

    /**
     * Creates new form CursoEditar
     */
    @Autowired
    public CursoEditar(CursoIController controller) {

     super((java.awt.Frame ) null,true);    
     this.cursoController = controller;
        
        initComponents();
    }
    
    public void prepararEdicao(Curso curso) {
        this.cursoParaEditar = curso;
        txtNomeedit.setText(curso.getNome());
        txtCodigoedit.setText(curso.getCodigoCurso());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnEditarcurso = new javax.swing.JButton();
        txtCodigoedit = new javax.swing.JTextField();
        lblCodigoedit = new javax.swing.JLabel();
        txtNomeedit = new javax.swing.JTextField();
        lblNomeedit = new javax.swing.JLabel();
        lblEditarCurso = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnEditarcurso.setText("Editar curso");
        btnEditarcurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarcursoActionPerformed(evt);
            }
        });

        lblCodigoedit.setText("Insira o novo codigo do curso");

        txtNomeedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeeditActionPerformed(evt);
            }
        });

        lblNomeedit.setText("Insira o novo nome do curso");

        lblEditarCurso.setText("EDITANDO CURSO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEditarCurso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNomeedit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCodigoedit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNomeedit)
                    .addComponent(txtCodigoedit))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addComponent(btnEditarcurso)
                .addContainerGap(147, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblEditarCurso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNomeedit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNomeedit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCodigoedit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCodigoedit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEditarcurso)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarcursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarcursoActionPerformed
        String novoNome = txtNomeedit.getText();
        String novoCodigo = txtCodigoedit.getText();

        if (novoNome.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nome inválido.");
            return;
        }
        // Atualiza o objeto da memória
        this.cursoParaEditar.setNome(novoNome);
        this.cursoParaEditar.setCodigoCurso(novoCodigo);

        try {
            this.cursoController.update(this.cursoParaEditar);

            JOptionPane.showMessageDialog(this, "Curso atualizado!");
            this.dispose(); // Fecha a janela

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao atualizar: " + e.getMessage());
        }
    }//GEN-LAST:event_btnEditarcursoActionPerformed

    private void txtNomeeditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeeditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeeditActionPerformed


  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditarcurso;
    private javax.swing.JLabel lblCodigoedit;
    private javax.swing.JLabel lblEditarCurso;
    private javax.swing.JLabel lblNomeedit;
    private javax.swing.JTextField txtCodigoedit;
    private javax.swing.JTextField txtNomeedit;
    // End of variables declaration//GEN-END:variables
}
