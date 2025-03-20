import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TodoItemComponent } from '../todo-item/todo-item.component';
import { TodoService } from '../../services/todo.service';
import { Todo } from '../../models/todo.interface';
import { FilterPipe } from '../../pipes/filter.pipe';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-todo-list',
  standalone: true,
  imports: [CommonModule, TodoItemComponent, FilterPipe, FormsModule],
  template: `
    <div class="todo-list">
      <div class="filters">
        <input
          type="text"
          [(ngModel)]="searchTerm"
          placeholder="Search todos..."
          class="search-input"
        >
        <select [(ngModel)]="filterStatus" class="filter-select">
          <option value="all">All</option>
          <option value="completed">Completed</option>
          <option value="active">Active</option>
        </select>
      </div>

      <div class="todos">
        @for (todo of todos$ | async | filter:searchTerm:filterStatus; track todo.id) {
          <app-todo-item
            [todo]="todo"
            (toggleComplete)="onToggleComplete($event)"
            (delete)="onDelete($event)"
          />
        } @empty {
          <p class="no-todos">No todos found</p>
        }
      </div>
    </div>
  `,
  styles: [`
    .todo-list {
      max-width: 800px;
      margin: 2rem auto;
      padding: 0 1rem;

      .filters {
        display: flex;
        gap: 1rem;
        margin-bottom: 2rem;

        .search-input, .filter-select {
          padding: 0.5rem;
          border: 1px solid #ddd;
          border-radius: 4px;
        }

        .search-input {
          flex: 1;
        }
      }

      .no-todos {
        text-align: center;
        color: #666;
        font-style: italic;
      }
    }
  `]
})
export class TodoListComponent {
  todos$;
  searchTerm = '';
  filterStatus = 'all';

  constructor(private todoService: TodoService) {
    this.todos$ = this.todoService.todos$;
  }

  onToggleComplete(todo: Todo): void {
    this.todoService.updateTodo({
      ...todo,
      completed: !todo.completed
    });
  }

  onDelete(id: number): void {
    this.todoService.deleteTodo(id);
  }
} 