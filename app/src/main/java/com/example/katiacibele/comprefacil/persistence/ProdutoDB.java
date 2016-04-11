package com.example.katiacibele.comprefacil.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.katiacibele.comprefacil.model.Produto;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by katia cibele on 01/04/2016.
 */
public class ProdutoDB extends PrincipalDAO {


    private static ProdutoDB produtoDB;



    public static ProdutoDB getInstance(Context context) {
        if (produtoDB == null) {
            produtoDB = new ProdutoDB(context);
        }
        return produtoDB;
    }

    public ProdutoDB(Context context) {
        super(context);
    }

    /** Método para retorno todos os produtos
     *   @return List<Produto>
     *   @param
     *   @throws
     *   @param */
    public List<Produto> listAllProdutos() {
        List<Produto> ps = new ArrayList<Produto>();
        //colunas de itens
        String[] cols = { COL_ID_PRODUTOS, COL_DESCRICAO_PRODUTO, COL_CATEGORIA_PRODUTOS,
                COL_MARCA_PRODUTO,COL_QUANT_PRODUTO,COL_VALOR_PRODUTO,COL_CARRINHO_PRODUTO,COL_SELECIONADO_PRODUTO,
                COL_IMAGE_PRODUTO };

        Cursor cursor = getWritableDatabase().query(TABLE_NAME_PRODUTOS, cols,
                null, null, null, null, null);
        while (cursor.moveToNext()) {
            Produto p = new Produto(
                    cursor.getInt(0),
                    cursor.getInt(1),
                    cursor.getFloat(2),
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



    /** Método para retorna um produto
     *   @return List<Produto>
     *   @param  descrição do produto
     *   @throws
     */
    public List<Produto> findProduto(String text) throws ParseException {
        List<Produto> produtos = new ArrayList<Produto>();
        Cursor cursor = getWritableDatabase().rawQuery(
                "SELECT * FROM " + TABLE_NAME_PRODUTOS + " WHERE "
                        + COL_DESCRICAO_PRODUTO + " LIKE '%" + text + "%' OR "
                        + COL_MARCA_PRODUTO + " LIKE '%" + text
                        + "%' ORDER BY " + COL_CATEGORIA_PRODUTOS + " DESC;", null);

        while (cursor.moveToNext()) {
            Produto p = new Produto(
                    cursor.getInt(0),
                    cursor.getInt(1),
                    cursor.getFloat(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getInt(5),
                    cursor.getInt(6) );


            p.setImagem(this.listImages(p));
            produtos.add(p);
        }
        return produtos;
    }

    /** Método para insere um produto no banco
     *   @return int
     *   @param -List de produtos
     *   @throws
     */
    public int insertProdutos(List<Produto> produtos) throws ParseException {
        int count = 0;
        SQLiteDatabase db = this.getWritableDatabase();
        for (Produto p : produtos) {
            if ((p.getId() != 0) && (hasProduto(p.getId()) == null)) {
                ContentValues values = new ContentValues();
                values.put(COL_ID_PRODUTOS,p.getId());
                values.put(COL_DESCRICAO_PRODUTO, p.getNome());
                values.put(COL_MARCA_PRODUTO, p.getMarca());
                values.put(COL_CARRINHO_PRODUTO, p.getCarrinho());
                values.put(COL_SELECIONADO_PRODUTO, p.getSelecionado());
                values.put(COL_CATEGORIA_PRODUTOS, p.getCategoria(p));
                values.put(COL_QUANT_PRODUTO, p.getQuantidade());
                values.put(COL_VALOR_PRODUTO, p.getPreço());
               // values.put(COL_IMAGE_PRODUTO, p.getImagem());

                insertImages(p, db);
                db.insert(TABLE_NAME_PRODUTOS, null, values);
                Log.i("Save", p.getNome());
                count++;
            }
        }
        db.close();
        return count;
    }

    /** Método para insere imagem a um determinado produto
     *   @return void
     *   @param - produto e database
     *   @throws
     */

    private void insertImages(Produto produto, SQLiteDatabase sqLiteDatabase) {

            ContentValues values = new ContentValues();
            values.put(COL_ID_PRODUTOS, produto.getId());
            values.put(COL_IMAGE_PRODUTO, produto.getImagem());
            values.put(COL_CATEGORY_IMAGE, produto.getCategoria(produto));
            sqLiteDatabase.insert(TABLE_NAME_IMAGES, null, values);

    }

    /** Método para que lista as imagens de um determinado produtos
     *   @return String
     *   @param - produto
     *   @throws
     */
 
    private String listImages(Produto p) {
      String images = new String();
        Cursor cursor = getWritableDatabase().rawQuery(
                "SELECT * FROM " + TABLE_NAME_IMAGES + " WHERE "
                        + COL_ID_PRODUTOS + " =" + p.getId() + " AND "
                        + COL_CATEGORY_IMAGE + " LIKE '%produto%' ;", null);
        while (cursor.moveToNext()) {
            String path =  cursor.getString(1);

            images= path;
        }
        return images;
    }


    /** Método que verifica se o produto existe
     *   @return produto
     *   @param - produtoid
     *   @throws
     */
    public Produto hasProduto(Integer produtoId) throws ParseException {
        Produto p;

        Cursor cursor = getWritableDatabase().rawQuery(
                "SELECT * FROM " + TABLE_NAME_PRODUTOS + " WHERE "
                        + COL_ID_PRODUTOS + "= '" + produtoId + "';", null);

        if (cursor.moveToFirst()) {
            p = new Produto(
                    cursor.getInt(0),
                    cursor.getInt(1),
                    cursor.getFloat(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getInt(5),
                    cursor.getInt(6) );
            return p;
        }
        return null;
    }
}
