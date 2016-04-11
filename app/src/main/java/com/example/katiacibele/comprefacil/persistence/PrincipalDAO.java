package com.example.katiacibele.comprefacil.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.katiacibele.comprefacil.model.Lista;
import com.example.katiacibele.comprefacil.model.Produto;

import java.text.ParseException;
import java.util.List;

/**
 * Created by katia cibele on 29/03/2016.
 */
public class PrincipalDAO extends SQLiteOpenHelper {

   private static PrincipalDAO dao;
    private static ProdutoDB produtoDB;

    protected static final Integer DATABASE_VERSION = 3;

    protected static final String TABLE_NAME_PRODUTOS = "PRODUTOS";
    protected static final String COL_ID_PRODUTOS = "ID";
    protected static final String COL_DESCRICAO_PRODUTO = "DESCRICAO";
    protected static final String COL_CATEGORIA_PRODUTOS = "CATEGORIA";
    protected static final String COL_VALOR_PRODUTO = "VALOR";
    protected static final String COL_QUANT_PRODUTO = "QUANTIDADE";
    protected static final String COL_MARCA_PRODUTO = "MARCA";
    protected static final String COL_SELECIONADO_PRODUTO = "SELECIONADO";
    protected static final String COL_CARRINHO_PRODUTO = "CARRINHO";
    protected static final String COL_IMAGE_PRODUTO ="IMAGEM";

    private static final String CREATE_TABLE_PRODUTO = "CREATE TABLE "
            + TABLE_NAME_PRODUTOS + "( " + COL_ID_PRODUTOS
            + " INTEGER PRIMARY KEY, " + COL_DESCRICAO_PRODUTO + " TEXT , "
            + COL_CATEGORIA_PRODUTOS + " TEXT , "
            + COL_VALOR_PRODUTO + " FLOAT , "
            + COL_QUANT_PRODUTO + " INTEGER , "
            + COL_MARCA_PRODUTO + " TEXT , "
            + COL_SELECIONADO_PRODUTO + " INTEGER , "
            + COL_CARRINHO_PRODUTO + "INTEGER , "
            + COL_IMAGE_PRODUTO + " TEXT );";

    protected static final String TABLE_NAME_LISTA = "LISTA";
    protected static final String COL_ID_LISTA = "ID";
    protected static final String COL_DESCRICAO_LISTA = "DESCRICAO";
    protected static final String COL_ATIVO_LISTA = "STATUS";
    protected static final String COL_DATE_LISTA = "DATE";

    private static final String CREATE_TABLE_LISTA = "CREATE TABLE "
            + TABLE_NAME_LISTA + "( " + COL_ID_PRODUTOS + " INTEGER, "
            + COL_ID_LISTA + " INTEGER, "
            + COL_DESCRICAO_LISTA + " TEXT, "
            + COL_ATIVO_LISTA  + " INTEGER, "
            + COL_DATE_LISTA + " DATE,"
            +" PRIMARY KEY(" + COL_ID_PRODUTOS + ","+COL_ID_LISTA+"));";





    protected static final String TABLE_NAME_RLISTAPRODUTO= "LISTAPRODUTO";
    protected static final String COL_ID_RLISTAPRODUTO = "IDLISTAPRODUTO";
    protected static final String COL_ID_LISTA_RLISTAPRODUTO= "IDLISTA";
    protected static final String COL_ID_PRODUTO_RLISTAPRODUTO = "IDPRODUTO";


    private static final String CREATE_TABLE_LISTA = "CREATE TABLE "
            + TABLE_NAME_LISTA + "( " + COL_ID_PRODUTOS + " INTEGER, "
            + COL_ID_LISTA + " INTEGER, "
            + COL_DESCRICAO_LISTA + " TEXT, "
            + COL_ATIVO_LISTA  + " INTEGER, "
            + COL_DATE_LISTA + " DATE,"
            +" PRIMARY KEY(" + COL_ID_PRODUTOS + ","+COL_ID_LISTA+"));";




    protected static final String TABLE_NAME_IMAGES = "IMAGES";
    protected static final String COL_PATH_IMAGE = "PATH";
    protected static final String COL_CATEGORY_IMAGE = "CATEGORIA"


    private static final String CREATE_TABLE_IMAGES = "CREATE TABLE "
            + TABLE_NAME_IMAGES + "( " + COL_ID_PRODUTOS + " INTEGER, "
            + COL_PATH_IMAGE + " TEXT, "
            + COL_CATEGORY_IMAGE + " TEXT,"
            +" PRIMARY KEY(" + COL_ID_PRODUTOS + ","+COL_PATH_IMAGE+"));";


    public PrincipalDAO(Context context) {
        super(context, "comprefacil_database", null, DATABASE_VERSION);
    }

    public static PrincipalDAO getInstance(Context context) {
        if (dao == null) {
            dao = new PrincipalDAO(context);
        }
       // produtoDB = produtoDB.getInstance(context);

        return dao;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_PRODUTO);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_PRODUTOS);

        onCreate(db);
    }


    public List<Produto> listAllNotices() {
        return produtoDB.listAllNotices();
    }


    public int insertProdutos(List<Produto> p) throws ParseException {
        return produtoDB.insertNotices(p);
    }

    public List<Produto> findProduto(String text) throws ParseException {
        return produtoDB.findNotices(text);
    }


    //Listas

    public List<Lista> listAllListas() {
        return ListaDB.listAllEvents();
    }


    public int insertLista(List<Lista> l) throws ParseException {
        return ListaDB.insertEvents(l);
    }


    public List<Lista> findLista(String listaTitle) throws ParseException {
        return ListaDB.findEvent(listaTitle);
    }
    public List<Lista> findListaId(int listaId) throws ParseException {
        return ListaDB.findEventId(eventId);
    }


    public void deleteLista(Integer listaId) {
        ListaDB.deleteEvent(listaId);
    }

    /**
     *
     */
    public void deleteAllLista() {
        ListaDB.deleteAllLista();
    }


}
