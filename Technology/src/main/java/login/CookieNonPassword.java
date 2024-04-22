package login;

/**
 * @description: 密码登录成功后响应回Cookie --> 再次登录时如果Cookie验证为真，则直接登录
 * @author: HammerRay
 * @date: 2024/4/22 下午6:17
 */
//public class CookieNonPassword extends HttpServlet{
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        Cookie [] cookies = request.getCookies();
//        if(cookies != null){
//            if(validateCookie(cookies)){
//                response.sendRedirect("welcome.jsp");
//            }else {
//                response.sendRedirect("login.jsp");
//            }
//        }
//        // 验证用户名和密码是否正确
//        if (validateCredentials(username, password)) {
//            // 创建Cookie并设置过期时间
//            Cookie loginCookie = new Cookie("login", "true");
//            loginCookie.setMaxAge(60 * 60 * 24); // 设置Cookie的有效期为1天
//            response.addCookie(loginCookie);
//
//            // 重定向到欢迎页面
//            response.sendRedirect("welcome.jsp");
//        } else {
//            // 认证失败，重定向到登录页面
//            response.sendRedirect("login.jsp");
//        }
//    }
//
//    private boolean validateCredentials(String username, String password) {
//        // 在这里编写验证用户名和密码的逻辑，例如查询数据库或调用其他服务进行验证
//        // 如果验证通过，返回true；否则返回false
//        return true; // 假设验证通过
//    }
//
//    private boolean validateCookie(Cookie[] cookies){
//        // 获取客户端发送的cookie信息
//        if (cookies != null) {
//            for (Cookie cookie : cookies) {
//                if ("user_id".equals(cookie.getName())) {
//                    // 验证cookie是否有效
//                    if (isValidCookie(cookie)) {
//                        // 根据cookie中保存的用户信息进行身份验证
//                        String userId = cookie.getValue();
//                        if (authenticateUser(userId)) {
//                            // 用户身份验证通过，允许访问受保护的资源或执行其他操作
//                            return true;
//                        }
//                    }
//                }
//            }
//        }
//    }
//}
