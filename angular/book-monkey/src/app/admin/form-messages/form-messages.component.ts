import {Component, Input} from '@angular/core';
import {AbstractControl} from "@angular/forms";

@Component({
  selector: 'bm-form-messages',
  templateUrl: './form-messages.component.html',
  styleUrls: ['./form-messages.component.css']
})
export class FormMessagesComponent {
  @Input() control!: AbstractControl;
  @Input() controlName!: string;

  private allMessages: any = {
    title: {
      required: 'Ein Buchtitel muss angegeben werden.'
    },
    isbn: {
      required: 'Es muss eine ISBN angegeben werden.',
      isbnFormat: 'Die ISBN muss aus 10 oder 13 Zeichen bestehen.',
      isbnExists: 'Die ISBN existiert bereits.'
    },
    published: {
      required: 'Es muss ein Erscheinungsdatum angegeben werden.'
    },
    authors: {
      atLeastOneAuthor: 'Es muss ein Autor angegeben werden.'
    }
  };

  errorForControl(): string[] | null {
    const messages = this.allMessages[this.controlName];
    if(!this.control || !this.control.errors || !messages || !this.control.dirty) {
      return null;
    }

    return Object.keys(this.control.errors).map(err => messages[err]);
  }
}
