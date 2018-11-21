package Servlets;

import Service.Impl.BookServiceImpl;
import bean.Book;
import bean.BookSearch;
import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by 96283 on 2018/11/7.
 */
public class BookServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
           //type:1 新增  2 删除 3 更新 4 查询
        String booksjson = "data";
        PrintWriter out = response.getWriter();
        BookServiceImpl bookService = new BookServiceImpl();
       int type = Integer.valueOf(request.getParameter("type"));
       if(1==type){
           //新增
           Book book = new Book();
           book.setName(request.getParameter("bookname"));
           book.setDescription(request.getParameter("description"));
           book.setKc(Integer.parseInt(request.getParameter("kc")));
           bookService.insertBook(book);
       }

       if(2==type){
           //删除
           bookService.deleteBook(Integer.parseInt(request.getParameter("id")));
       }
        if(4==type){
            //查询
            BookSearch bookSearch = new BookSearch();
            String bookname = request.getParameter("bookname");
            if(null!=request.getParameter("bookname")&&!bookname.equals("")){
                bookSearch.setName(request.getParameter("bookname"));
            }
            String description = request.getParameter("description");
            if(null!=description&&!description.equals("")){
                bookSearch.setDescription(description);
            }
            String kc = request.getParameter("kc");
            if(null!=request.getParameter("kc")&&!kc.equals("")){
                int kc1 = Integer.parseInt(kc);
                bookSearch.setKc(kc1);
            }


            List<Book> books = bookService.getBooks(bookSearch);

            for(Book book:books){
                 booksjson += JSON.toJSONString(book);
            }
            out.write(booksjson);

        }




    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
          this.doPost(request,response);
    }
}
