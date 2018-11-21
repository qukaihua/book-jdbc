package Service.Impl;

import Service.BookService;
import Util.JdbcUtil;
import bean.Book;
import bean.BookSearch;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 96283 on 2018/11/7.
 */
public class BookServiceImpl implements BookService {

    private static  Connection conn;


  static {
      conn= JdbcUtil.getConn();
  }


    PreparedStatement ps;
    @Override
    public void insertBook(Book book) {
        String sql = "insert into book (name,description,kc,status) values(?,?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,book.getName());
            ps.setString(2,book.getDescription());
            ps.setInt(3,book.getKc());
            ps.setInt(4,1);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                ps.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }

    @Override
    public void deleteBook(int id) {
        String sql = "update book set status=2 where id="+id+"";
        try {
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                ps.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }

    @Override
    public void updateBook(Book book) {


    }

    @Override
    public List<Book> getBooks(BookSearch bookSearch) {
        List<Book> books = new ArrayList<Book>();
        String sql;
        if(null!=bookSearch.getName()&&null!=bookSearch.getDescription()&&bookSearch.getKc()!=0){
            sql = "select * from book where name='"+bookSearch.getName()+"' and description='"+bookSearch.getDescription()+"' and kc='"+bookSearch.getKc()+"'";
            try {
                ps= conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    Book book =new Book();
                    book.setId(rs.getInt("id"));
                    book.setName(rs.getString("name"));
                    book.setDescription(rs.getString("description"));
                    book.setKc(rs.getInt("kc"));
                    books.add(book);
                }
                return books;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(null==bookSearch.getName()&&null==bookSearch.getDescription()&&bookSearch.getKc()==0){
            sql = "select * from book ";
            try {
                ps= conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    Book book =new Book();
                    book.setId(rs.getInt("id"));
                    book.setName(rs.getString("name"));
                    book.setDescription(rs.getString("description"));
                    book.setKc(rs.getInt("kc"));
                    books.add(book);
                }
                return books;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(null!=bookSearch.getName()&&null!=bookSearch.getDescription()&&bookSearch.getKc()==0){
            sql = "select * from book where name='"+bookSearch.getName()+"' and description='"+bookSearch.getDescription()+"'";
            try {
                ps= conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    Book book =new Book();
                    book.setId(rs.getInt("id"));
                    book.setName(rs.getString("name"));
                    book.setDescription(rs.getString("description"));
                    book.setKc(rs.getInt("kc"));
                    books.add(book);
                }
                return books;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(null==bookSearch.getName()&&null!=bookSearch.getDescription()&&bookSearch.getKc()!=0){
            sql = "select * from book where  description='"+bookSearch.getDescription()+"' and kc='"+bookSearch.getKc()+"'";
            try {
                ps= conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    Book book =new Book();
                    book.setId(rs.getInt("id"));
                    book.setName(rs.getString("name"));
                    book.setDescription(rs.getString("description"));
                    book.setKc(rs.getInt("kc"));
                    books.add(book);
                }
                return books;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(null!=bookSearch.getName()&&null==bookSearch.getDescription()&&bookSearch.getKc()!=0){
            sql = "select * from book where name='"+bookSearch.getName()+"' and  kc='"+bookSearch.getKc()+"'";
            try {
                ps= conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    Book book =new Book();
                    book.setId(rs.getInt("id"));
                    book.setName(rs.getString("name"));
                    book.setDescription(rs.getString("description"));
                    book.setKc(rs.getInt("kc"));
                    books.add(book);
                }
                return books;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(null!=bookSearch.getName()&&null==bookSearch.getDescription()&&bookSearch.getKc()==0){
            sql = "select * from book where name='"+bookSearch.getName()+"'";
            try {
                ps= conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    Book book =new Book();
                    book.setId(rs.getInt("id"));
                    book.setName(rs.getString("name"));
                    book.setDescription(rs.getString("description"));
                    book.setKc(rs.getInt("kc"));
                    books.add(book);
                }
                return books;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(null==bookSearch.getName()&&null==bookSearch.getDescription()&&bookSearch.getKc()!=0){
            sql = "select * from book where  kc='"+bookSearch.getKc()+"'";
            try {
                ps= conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    Book book =new Book();
                    book.setId(rs.getInt("id"));
                    book.setName(rs.getString("name"));
                    book.setDescription(rs.getString("description"));
                    book.setKc(rs.getInt("kc"));
                    books.add(book);
                }
                return books;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(null==bookSearch.getName()&&null!=bookSearch.getDescription()&&bookSearch.getKc()==0){
            sql = "select * from book where description='"+bookSearch.getDescription()+"'";
            try {
                ps= conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    Book book =new Book();
                    book.setId(rs.getInt("id"));
                    book.setName(rs.getString("name"));
                    book.setDescription(rs.getString("description"));
                    book.setKc(rs.getInt("kc"));
                    books.add(book);
                }
                return books;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }



        return null;
    }}

