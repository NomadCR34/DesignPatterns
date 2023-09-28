package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Composition {

    public static void main(String[] args) {
        Todo todo1 = new Todo("This is todo one");
        todo1.operation();

        Todo todo2 = new Todo("This is todo two");
        Todo todo3 = new Todo("This is todo three");
        Todo todo4 = new Todo("This is todo four");

        Project subProject1 = new Project("SubProject 1");
        subProject1.add(todo1);
        subProject1.add(todo2);
        subProject1.add(todo3);

        Project subProject2 = new Project("SubProject 2");
        subProject2.add(todo4);

        Project mainProject = new Project("Main Project");
        mainProject.add(subProject1);
        mainProject.add(subProject2);

        mainProject.operation();


    }
}

interface TodoList{
    void operation();
}

class Todo implements TodoList{

    private final String text;

    public Todo(String text) {
        this.text = text;
    }

    @Override
    public void operation() {
        System.out.println(text);
    }
}

class Project implements TodoList{

    private final String title;
    private List<TodoList> todoLists; // one to many

    public Project(String title) {
        this.title = title;
        this.todoLists = new ArrayList<>();
    }

    @Override
    public void operation() {
        //do something
        System.out.println(title);
        todoLists.forEach(TodoList::operation);
        //do something
    }

    public void add(TodoList todo){
        if(Objects.isNull(todoLists)){
            todoLists = new ArrayList<>();
        }
        todoLists.add(todo);
    }

    public void remove(TodoList todo){
        todoLists.remove(todo);
    }
}
