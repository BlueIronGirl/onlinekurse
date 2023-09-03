import {Component, OnInit} from '@angular/core';
import {Book} from '../../shared/book';
import {BookStoreService} from '../../shared/book-store.service';
import {Observable} from "rxjs";
import {select, Store} from "@ngrx/store";
import {loadBooks} from "../store/book.actions";
import {selectAllBooks, selectBooksLoading} from '../store/book.selectors';


@Component({
  selector: 'bm-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit {
  constructor(private store: Store) {
  }

  books$ = this.store.pipe(select(selectAllBooks));
  loading$ = this.store.pipe(select(selectBooksLoading));

  ngOnInit(): void {
    this.store.dispatch(loadBooks());
  }
}
