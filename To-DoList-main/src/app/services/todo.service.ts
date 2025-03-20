import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { Todo } from '../models/todo.interface';

@Injectable({
  providedIn: 'root'
})
export class TodoService {
  private todos = new BehaviorSubject<Todo[]>([
    {
      id: 1,
      title: 'Complete Angular Tutorial',
      description: 'Learn about components, services, and routing in Angular',
      completed: false,
      createdAt: new Date('2024-03-10')
    },
    {
      id: 2,
      title: 'Prepare Project Documentation',
      description: 'Write comprehensive documentation for the team project including setup instructions and API endpoints',
      completed: true,
      createdAt: new Date('2024-03-09')
    },
    {
      id: 3,
      title: 'Review Pull Requests',
      description: 'Review and provide feedback on team members\' code submissions',
      completed: false,
      createdAt: new Date('2024-03-11')
    },
    {
      id: 4,
      title: 'Update Dependencies',
      description: 'Check and update project dependencies to their latest stable versions',
      completed: false,
      createdAt: new Date('2024-03-08')
    },
    {
      id: 5,
      title: 'Implement User Authentication',
      description: 'Add login and registration functionality with JWT authentication',
      completed: false,
      createdAt: new Date('2024-03-12')
    }
  ]);
  todos$ = this.todos.asObservable();

  constructor(private http: HttpClient) {}

  addTodo(todo: Omit<Todo, 'id'>): void {
    const currentTodos = this.todos.value;
    const newTodo: Todo = {
      ...todo,
      id: Math.max(...currentTodos.map(t => t.id), 0) + 1
    };
    this.todos.next([...currentTodos, newTodo]);
  }

  updateTodo(todo: Todo): void {
    const currentTodos = this.todos.value;
    const index = currentTodos.findIndex(t => t.id === todo.id);
    if (index !== -1) {
      currentTodos[index] = todo;
      this.todos.next([...currentTodos]);
    }
  }

  deleteTodo(id: number): void {
    const currentTodos = this.todos.value;
    this.todos.next(currentTodos.filter(todo => todo.id !== id));
  }
} 