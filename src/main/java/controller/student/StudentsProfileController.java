package controller.student;

import dao.student.DBStudents;
import model.Student;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;

@MultipartConfig
@WebServlet(name = "StudentsProfileController", value="/studentProfile")
public class StudentsProfileController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id != null && id!="") {
            DBStudents dbStudents = new DBStudents();
            try {
                Student student = dbStudents.getStudentById(Integer.parseInt(id));
                String avatarFilePath = "../resources/img/avatar/men-silhouette.png";
                if (student.getAvatar() != null) {
                    avatarFilePath = "" + student.getId() + ".jpeg";
                    File avatarFile = new File(avatarFilePath);
                    avatarFile.createNewFile();
                    FileOutputStream fos = new FileOutputStream(avatarFile);
                   // fos.write(student.getAvatar().getBytes(avatarFile.length(),));
                    fos.close();
                }
                req.setAttribute("firstname", student.getFirstname());
                req.setAttribute("lastname", student.getLastname());
                req.setAttribute("middlename", student.getMiddlename());
                req.setAttribute("groupid", student.getGroupid());
                req.setAttribute("email", student.getEmail());
                req.setAttribute("phonenumber", student.getPhoneNumber());
                req.setAttribute("recieptdate", student.getRecieptDate());
                req.setAttribute("status", student.isStatus());
                req.setAttribute("studentid", student.getId());
                req.setAttribute("avatarFilePath", avatarFilePath);
                req.getRequestDispatcher("JSP/studentProfile.jsp").forward(req, resp);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        req.getRequestDispatcher("JSP/studentProfile.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        //get parameters
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setRepository(new File(""));
        ServletFileUpload upload = new ServletFileUpload(factory);

        List fileItems = null;
        try {
            fileItems = upload.parseRequest(req);
            Iterator i = fileItems.iterator();
            while ( i.hasNext () ) {
                FileItem fi = (FileItem)i.next();
                if ( !fi.isFormField () ) {
                    // Get the uploaded file parameters
                    String fileName = fi.getName();
                    // Write the file
                    if( fileName.lastIndexOf("\\") >= 0 ) {
                       // file = new File( filePath + fileName.substring( fileName.lastIndexOf("\\"))) ;
                    } else {
                       // file = new File( filePath + fileName.substring(fileName.lastIndexOf("\\")+1)) ;
                    }
                }
            }
        } catch (FileUploadException e) {
            throw new RuntimeException(e);
        }
        Iterator i = fileItems.iterator();

        String id = req.getParameter("id");
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String middlename = req.getParameter("middlename");
        String groupid = req.getParameter("groupid");
        LocalDate recieptdate = LocalDate.MIN;
        if (req.getParameter("recieptdate") != "") {
            recieptdate = LocalDate.parse(req.getParameter("recieptdate"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }
        String email = req.getParameter("email");
        String phonenumber = req.getParameter("phonenumber");
        boolean status = Boolean.parseBoolean(req.getParameter("status"));
        Part avatarFilePart = req.getPart("avatarfile");
        InputStream avatarFileContent = avatarFilePart.getInputStream();
        avatarFileContent.read();

        Student student = new Student();
        student.setFirstname(firstname);
        student.setLastname(lastname);
        student.setMiddlename(middlename);
        student.setGroupid(Integer.parseInt(groupid));
        student.setStatus(Boolean.parseBoolean(String.valueOf(status)));
        student.setPhoneNumber(phonenumber);
        student.setRecieptDate(recieptdate);
       // student.setAvatar(avatarFileContent.readAllBytes());
        if (id != "") {
            student.setId(Integer.parseInt(id));
        }
        student.setEmail(email);


        DBStudents dbStudents = new DBStudents();
        try {
            if (dbStudents.createStudents(student)) {
                    resp.sendRedirect("/students");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
