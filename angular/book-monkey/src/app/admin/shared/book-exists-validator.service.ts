import { Injectable } from '@angular/core';
import {AsyncValidator, FormControl, ValidationErrors} from '@angular/forms';
import {BookStoreService} from '../../shared/book-store.service';
import {catchError, map, Observable, of} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BookExistsValidatorService implements AsyncValidator{

  constructor(private bs: BookStoreService) { }

  validate(control: FormControl): Observable<ValidationErrors | null> {
    return this.bs.check(control.value).pipe(
      map(exists => (exists === false) ? null : {
        isbnExists: {valid: false}
      }),
      catchError(()=> of(null)));
  }
}
