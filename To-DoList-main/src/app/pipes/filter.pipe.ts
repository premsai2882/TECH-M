import { Pipe, PipeTransform } from '@angular/core';
import { Todo } from '../models/todo.interface';

@Pipe({
  name: 'filter',
  standalone: true
})
export class FilterPipe implements PipeTransform {
  transform(todos: Todo[] | null, searchTerm: string, status: string): Todo[] {
    if (!todos) return [];
    
    return todos.filter(todo => {
      const matchesSearch = todo.title.toLowerCase().includes(searchTerm.toLowerCase()) ||
                          todo.description.toLowerCase().includes(searchTerm.toLowerCase());
      
      const matchesStatus = status === 'all' ? true :
                           status === 'completed' ? todo.completed :
                           !todo.completed;
      
      return matchesSearch && matchesStatus;
    });
  }
} 