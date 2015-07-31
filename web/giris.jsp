
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Rehber Uygulaması</title>
</head>
<body>
    <form method="post" action="girisKontrol">
        
        <%
          Object hataObj = request.getAttribute("Hata");
          if(hataObj!=null){
              out.println(String.valueOf(hataObj));
          }
        %>
        <table align="center">
            
            <tr><th colspan="2">Giriş Bilgileri</th></tr>
            <tr><td>Kullanıcı Adı:</td><td><input type="text" name="kullanici"></input></td></tr>
            <tr><td>Şifre:</td><td><input type="password" name="sifre"></input ></td></tr>
            <tr><td colspan="2"><input type="submit" name="buton" value="Giriş"></input></td></tr>
            
        </table>
    </form>
    
</body>
</html>
