import {Component, OnInit} from '@angular/core';
import {Booking} from "../booking";
import {BookingService} from "../shared/booking.service";

@Component({
  selector: 'app-bookings',
  templateUrl: './bookings.component.html',
  styleUrls: ['./bookings.component.css']
})
export class BookingsComponent implements OnInit {

  constructor(private bookingService: BookingService) {
  }

  bookings: Booking[] = [];

  ngOnInit(): void {
    this.bookingService.getBookings().subscribe((result) => {
      this.bookings = result;
    });
  }

  deleteBooking(booking: Booking) {
    this.bookingService.deleteBooking(booking).subscribe((result) => {
      this.bookings = this.bookings.filter(b => b != result);
    });
  }
}
