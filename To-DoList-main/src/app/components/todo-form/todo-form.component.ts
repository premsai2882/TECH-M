import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { TodoService } from '../../services/todo.service';

@Component({
  selector: 'app-todo-form',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  template: `
    <div class="todo-form">
      <h2>Add New Todo</h2>
      <form [formGroup]="todoForm" (ngSubmit)="onSubmit()">
        <div class="form-group">
          <label for="title">Title</label>
          <input
            id="title"
            type="text"
            formControlName="title"
            [class.invalid]="isFieldInvalid('title')"
          >
          <div class="error" *ngIf="isFieldInvalid('title')">
            Title is required
          </div>
        </div>

        <div class="form-group">
          <label for="description">Description</label>
          <textarea
            id="description"
            formControlName="description"
            [class.invalid]="isFieldInvalid('description')"
          ></textarea>
          <div class="error" *ngIf="isFieldInvalid('description')">
            Description is required
          </div>
        </div>

        <button type="submit" [disabled]="todoForm.invalid">Add Todo</button>
      </form>
    </div>
  `,
  styles: [`
    .todo-form {
      max-width: 500px;
      margin: 2rem auto;
      padding: 2rem;
      border: 1px solid #ddd;
      border-radius: 4px;

      h2 {
        margin-bottom: 1.5rem;
      }

      .form-group {
        margin-bottom: 1rem;

        label {
          display: block;
          margin-bottom: 0.5rem;
        }

        input, textarea {
          width: 100%;
          padding: 0.5rem;
          border: 1px solid #ddd;
          border-radius: 4px;

          &.invalid {
            border-color: #ff4444;
          }
        }

        textarea {
          min-height: 100px;
        }

        .error {
          color: #ff4444;
          font-size: 0.875rem;
          margin-top: 0.25rem;
        }
      }

      button {
        width: 100%;
        padding: 0.75rem;
        background-color: #4CAF50;
        color: white;
        border: none;
        border-radius: 4px;
        cursor: pointer;

        &:disabled {
          background-color: #ccc;
          cursor: not-allowed;
        }
      }
    }
  `]
})
export class TodoFormComponent implements OnInit {
  todoForm!: FormGroup;

  constructor(
    private fb: FormBuilder,
    private todoService: TodoService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.todoForm = this.fb.group({
      title: ['', [Validators.required]],
      description: ['', [Validators.required]]
    });
  }

  isFieldInvalid(field: string): boolean {
    const formControl = this.todoForm.get(field);
    return formControl ? formControl.invalid && formControl.touched : false;
  }

  onSubmit(): void {
    if (this.todoForm.valid) {
      const newTodo = {
        ...this.todoForm.value,
        completed: false,
        createdAt: new Date()
      };
      
      this.todoService.addTodo(newTodo);
      this.router.navigate(['/']);
    } else {
      Object.keys(this.todoForm.controls).forEach(key => {
        const control = this.todoForm.get(key);
        if (control) {
          control.markAsTouched();
        }
      });
    }
  }
} 