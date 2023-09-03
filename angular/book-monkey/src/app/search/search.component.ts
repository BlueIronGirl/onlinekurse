import {Component, OnInit} from '@angular/core';
import {debounceTime, distinctUntilChanged, filter, Observable, Subject, switchMap, tap} from "rxjs";
import {BookStoreService} from "../shared/book-store.service";
import {Book} from "../shared/book";

@Component({
  selector: 'bm-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  keyUp$ = new Subject<string>();
  isLoading = false;
  foundBooks$: Observable<Book[]> | undefined;

  constructor(private bs: BookStoreService) {
  }

  ngOnInit(): void {
    this.foundBooks$ = this.keyUp$.pipe(
      filter(term => term.length >= 3),
      debounceTime(500), // erst nach 500 ms seit der letzten Eingabe wieder Eingaben entgegennehmen
      distinctUntilChanged(), // Doppelte Filtern
      tap(() => this.isLoading = true),
      switchMap(searchTerm => this.bs.getAllSearch(searchTerm)), // switchMap damit bei neuen Eingaben der alte Request sofort abgebrochen wird und ein neuer gestartet wird
      tap(() => this.isLoading = false)
    );
  }
}
