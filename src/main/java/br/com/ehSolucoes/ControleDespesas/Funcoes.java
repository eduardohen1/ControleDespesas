package br.com.ehSolucoes.ControleDespesas;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Funcoes {
	
	public Date retornaData(int dia, int mes, int ano){
		Calendar c = Calendar.getInstance();
		c.set(ano, mes, dia);
		/*c.set(Calendar.YEAR, ano);
		c.set(Calendar.MONTH, mes);
		c.set(Calendar.DAY_OF_MONTH, dia);*/		
		Date data = c.getTime();
		return data;
	}
	
	/**
	 * Converte uma String para um objeto Date. Caso a String seja vazia ou nula, 
	 * retorna null - para facilitar em casos onde formulários podem ter campos
	 * de datas vazios.
	 * @param data String no formato dd/MM/yyyy a ser formatada
	 * @return Date Objeto Date ou null caso receba uma String vazia ou nula
	 */
	public static Date formataData(String data) { 
		if (data == null || data.equals(""))
			return null;
        Date date = null;
        try {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            date = (Date)formatter.parse(data);
        } catch (Exception e) {            
            System.out.println("Erro: " + e.getMessage());
        }
        return date;
	}
	
}
