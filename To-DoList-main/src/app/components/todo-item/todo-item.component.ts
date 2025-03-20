import { Component, Input, Output, EventEmitter } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Todo } from '../../models/todo.interface';

@Component({
  selector: 'app-todo-item',
  standalone: true,
  imports: [CommonModule],
  template: `
    <div class="todo-item" [class.completed]="todo.completed">
      <div class="todo-content">
        <h3>{{ todo.title }}</h3>
        <p>{{ todo.description }}</p>
        <small>Created: {{ todo.createdAt | date }}</small>
      </div>
      <div class="todo-actions">
        <button (click)="onToggle()">
          {{ todo.completed ? 'Mark Incomplete' : 'Mark Complete' }}
        </button>
        <button (click)="onDelete()" class="delete">Delete</button>
      </div>
    </div>
  `,
  styles: [`
    .todo-item {
      border: 1px solid #ddd;
      padding: 1rem;
      margin-bottom: 1rem;
      border-radius: 4px;
      
      &.completed {
        background-color: #f8f8f8;
        .todo-content {
          text-decoration: line-through;
        }
      }

      .todo-content {
        margin-bottom: 1rem;
      }

      .todo-actions {
        display: flex;
        gap: 0.5rem;
        
        button {
          padding: 0.5rem 1rem;
          border: none;
          border-radius: 4px;
          cursor: pointer;
          
          &.delete {
            background-color: #ff4444;
            color: white;
          }
        }
      }
    }
  `]
})
export class TodoItemComponent {
  @Input({ required: true }) todo!: Todo;
  @Output() toggleComplete = new EventEmitter<Todo>();
  @Output() delete = new EventEmitter<number>();

  onToggle(): void {
    this.toggleComplete.emit(this.todo);
  }

  onDelete(): void {
    this.delete.emit(this.todo.id);
  }
} 