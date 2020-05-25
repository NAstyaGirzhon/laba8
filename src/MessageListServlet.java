import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.String;

@WebServlet("/messages.do")
public class MessageListServlet extends ChatServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// Установить кодировку HTTP-ответа UTF-8
        response.setCharacterEncoding("utf8");
        // Получить доступ к потоку вывода HTTP-ответа
        PrintWriter pw = response.getWriter();
// Записть в поток HTML-разметку страницы
        pw.println("<html><head><meta http-equiv= 'Content-Type' content='text/html; charset=utf-8'/><meta http-equiv='refresh' content='10'></head>");
        pw.println("<body>");
// В обратном порядке записать в поток HTML-разметку для каждого сообщения
        int HAPPY = 0x1F600; // U+1F928.
        final int BAKA =0x1F616;
        final int ZEM = 0x1F618;
        int m=0;

        String[] razd = {":)",">~<","^^~"};

        for (int i=messages.size()-1; i>=0; i--) {
            ChatMessage aMessage = messages.get(i);
            String  mess = aMessage.getMessage();
            String[] f = mess.split(" ");
            String xaz = " " ;

            for (String number : f){
                for( i=0; i< razd.length; i++) {
                    if (number.equals(razd[i])) {
                        m = i;
                        String smail = new String( new int[]{HAPPY, BAKA, ZEM}, m, 1);
                        xaz = xaz + number.replace(razd[i], smail);
                        break;
                    }
                    else if ( i==2){
                        xaz += number;
                    }
                }

            }
            pw.println("<div><strong>" + aMessage.getAuthor().getName() + "</strong>: " + xaz + "</div>");

        }
        pw.println("</body></html>");
    }
}

