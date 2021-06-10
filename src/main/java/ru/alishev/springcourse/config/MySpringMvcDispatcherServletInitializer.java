package ru.alishev.springcourse.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

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
}
