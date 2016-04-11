package com.example.katiacibele.comprefacil.persistence;

import android.content.Context;
import android.database.Cursor;

import com.example.katiacibele.comprefacil.model.Lista;
import com.example.katiacibele.comprefacil.model.Produto;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by katia cibele on 05/04/2016.
 */
public class ListaDB extends PrincipalDAO {


    public ListaDB(Context context) {
        super(context);
    }

    /** Método que lista todas as listas de compras existentes
     *   @return List<Lista></Lista>
     *   @param
     *   @throws
     */

    @Override
    public List<Lista> listAllListas() {

        List<Lista> lista = new ArrayList<Lista>();
        //colunas de itens
        String[] cols = { COL_ID_PRODUTOS, COL_DESCRICAO_PRODUTO, COL_CATEGORIA_PRODUTOS,
                COL_MARCA_PRODUTO,COL_QUANT_PRODUTO,COL_VALOR_PRODUTO,COL_CARRINHO_PRODUTO,COL_SELECIONADO_PRODUTO,
                COL_IMAGE_PRODUTO };

        Cursor cursor = getWritableDatabase().query(TABLE_NAME_LISTA, cols,
                null, null, null, null, null);
        while (cursor.moveToNext()) {
           Lista l = new Lista(
                    cursor.getInt(0),
                    cursor.getInt(1),
                    cursor.get(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getInt(5),
                    cursor.getInt(6) );



            String imagens = this.listImages(p);
            p.setImagem(imagens);
            ps.add(p);

        }
        cursor.close();
        return ps;
    }

    /** Método para insere uma lista no banco
     *   @return int
     *   @param -List<lista></lista>
     *   @throws
     */

    @Override
    public int insertLista(List<Lista> l) throws ParseException {
        return super.insertListas(l);
    }

    /** Método para encontrar uma lista no banco
     *   @return List<lista></>
     *   @param -descricao da lista
     *   @throws
     */
    @Override
    public List<Lista> findLista(String listaTitle) throws ParseException {
        return super.findLista(listaTitle);
    }

    /** Método para encontrar uma lista nobanco
     *   @return Lista
     *   @param -id da lista
     *   @throws
     */


    @Override
    public Lista findListaId(int listaId) throws ParseException {
        return super.findListaId(listaId);
    }

    @Override
    public void deleteLista(Integer listaId) {
        super.deleteLista(listaId);
    }

    @Override
    public void deleteAllLista() {
        super.deleteAllLista();
    }
}
