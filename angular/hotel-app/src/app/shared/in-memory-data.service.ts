import { Injectable } from '@angular/core';
import {InMemoryDbService} from "angular-in-memory-web-api";
import {Booking} from "../booking";

@Injectable({
  providedIn: 'root'
})
export class InMemoryDataService implements InMemoryDbService{

  constructor() { }

  createDb() {
    const bookings: Booking[] = [
      {
        id: 1,
        name: "Alice Bedow",
        roomNumber: 100,
        startDate: new Date(),
        endDate: new Date("2023-02-10")
      },
      {
        id: 2,
        name: "Max Mustermann",
        roomNumber: 60,
        startDate: new Date("2021-07-25"),
        endDate: new Date("2021-08-01")
      },
      {
        id: 3,
        name: "John Doe",
        roomNumber: 2,
        startDate: new Date("2021-08-04"),
        endDate: new Date("2021-08-11")
      }
    ];
    return {bookings};
  }
}
