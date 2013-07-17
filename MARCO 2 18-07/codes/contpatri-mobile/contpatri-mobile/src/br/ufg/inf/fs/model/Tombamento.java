package br.ufg.inf.fs.model;


import java.util.ArrayList;


import org.json.JSONException;
import org.json.JSONObject;


public class Tombamento {

	private final String idTombamento = "idTombamento";
	  private final String ultimaAlteracao = "ultimaAlteracao";
	  private final String situacao = "situacao";
	  private final String subLocal = "subLocal";
	  private final String observacao = "observacao";
	  private final String descricao = "descricao";
	  
	  JSONObject fichaAJSON = new JSONObject();
	  
	  public Tombamento(String jsonString) throws JSONException{
		  this.fichaAJSON = new JSONObject(jsonString);
	  
				  
	  }
	  
	  public Tombamento(JSONObject jsonObj) throws JSONException{
		  this.fichaAJSON = jsonObj;
		  
		  
				  
	  }
  
	  
	  
	  private String obterTimeStamp(){
		  Long tsLong = System.currentTimeMillis()/1000;
		 return tsLong.toString();
		}
	  
	  
	  
	  public String getIdTombamento() throws JSONException {
			return 	fichaAJSON.getString(idTombamento);
		}
		public void setIdTombamento(String idTombamento) throws JSONException {
			fichaAJSON.put(this.idTombamento, idTombamento);
		
		
		}
		
		 public String getDescricao() throws JSONException {
				return 	fichaAJSON.getString(descricao);
			}
			public void setDescricao(String descricao) throws JSONException {
				fichaAJSON.put(this.descricao, descricao);
			
			
			}
	
		public String getSituacao() throws JSONException {
			return 	fichaAJSON.getString(situacao);
		}
		public void setSituacao(String situacao) throws JSONException {
			fichaAJSON.put(this.situacao, situacao);
		
		
		}
		public String getSubLocal() throws JSONException {
			return 	fichaAJSON.getString(subLocal);
		}
		public void setSubLocal(String subLocal) throws JSONException {
			fichaAJSON.put(this.subLocal, subLocal);
		
		
		}
		
		public String getObservacao() throws JSONException {
			return 	fichaAJSON.getString(observacao);
		}
		public void setObservacao(String observacao) throws JSONException {
			fichaAJSON.put(this.observacao, observacao);
		
		
		}
		
		
		public String getTombamentoUltimaAlteracao() throws JSONException {
			return 	fichaAJSON.getString(ultimaAlteracao);
		}
		public void setTombamentoUltimaAlteracao(String ultimaAlteracao) throws JSONException {
			fichaAJSON.put(this.ultimaAlteracao, ultimaAlteracao);
	
			
		}
		public void registraTombamentoUltimaAlteracao() throws JSONException {
			fichaAJSON.put(ultimaAlteracao, obterTimeStamp());
	
			
		}
		
	}
	
