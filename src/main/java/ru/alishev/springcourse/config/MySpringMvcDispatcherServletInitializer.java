package ru.alishev.springcourse.config;

import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

//  Данный класс заменяет файл web.xml
public class MySpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
//    Данный метод не используется
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

//    Указываем, какие классы необходимо использовать для конфигурации проекта
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {SpringConfig.class};
    }

//    Все запросы от пользователя будут перенаправлены на DispatcherServlet
    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        registerHiddenFieldFilter(servletContext);
    }

    private void registerHiddenFieldFilter(ServletContext context) {
        context.addFilter("hiddenHttpMethodFilter",
                new HiddenHttpMethodFilter())
                .addMappingForUrlPatterns(null, true, "/*");
    }
}
