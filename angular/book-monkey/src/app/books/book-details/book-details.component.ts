import {Component, Input, OnInit, Output} from '@angular/core';
import {Book} from '../../shared/book';
import {BookStoreService} from '../../shared/book-store.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Observable} from "rxjs";

@Component({
  selector: 'bm-book-details',
  templateUrl: './book-details.component.html',
  styleUrls: ['./book-details.component.css']
})
export class BookDetailsComponent implements OnInit {
  book$: Observable<Book> | undefined;

  constructor(private bs: BookStoreService, private router: Router, private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    const params = this.route.snapshot.paramMap;
    this.book$ = this.bs.getSingle(params.get('isbn'));
  }

  getRating(num: number) {
    return new Array(num);
  }

  removeBook(book: Book) {
    if (confirm('Buch wirklich löschen?') && book) {
      this.bs.remove(book.isbn).subscribe(
        () => this.router.navigate(['../'], {relativeTo: this.route})
      );
    }
  }
}
