package view;

import javax.swing.JOptionPane;

import com.willoak.utils.fila.string.Fila;

import controller.ImpressoraController;

public class Principal {

	public static void main(String[] args) {
		Fila f = new Fila();
		ImpressoraController impressora = new ImpressoraController();

		String[] actionButtons = { "Adicionar arquivo para impressão", "imprimir arquivos", "Cancelar" };

		int opcao = 0;

		do {
			opcao = JOptionPane.showOptionDialog(null, "Qual será a ação?", "Confirmation",
					JOptionPane.INFORMATION_MESSAGE, 0, null, actionButtons, actionButtons[0]);

			switch (opcao) {
			case 0:
				String nomeArquivo = JOptionPane.showInputDialog(null, "Insira o nome do documento");

				if (impressora.validaDocumento(nomeArquivo)) {
					impressora.insereDocumento(f, nomeArquivo);
				} else {
					JOptionPane.showMessageDialog(null, "Documento inválido");
					opcao = 0;
				}

				break;

			case 1:
				try {
					impressora.imprime(f);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Documentos impressos");
				}
				
				break;
			}

		} while (opcao != 2);

	}

}
