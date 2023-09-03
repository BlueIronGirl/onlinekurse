import {Component, OnInit} from '@angular/core';
import {Booking} from "../booking";
import {ActivatedRoute, Router} from "@angular/router";
import {BookingService} from "../shared/booking.service";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-creating-booking',
  templateUrl: './creating-booking.component.html',
  styleUrls: ['./creating-booking.component.css']
})
export class CreatingBookingComponent implements OnInit {
  constructor(private router: Router,
              private activatedRoute: ActivatedRoute,
              private bookingService: BookingService,
              private formBuilder: FormBuilder) {
  }

  bookingForm: FormGroup = this.formBuilder.group({
    id: ['', Validators.required],
    name: ['', Validators.compose([Validators.required, Validators.minLength(5)])],
    roomNumber: ['', Validators.required],
    startDate: [new Date(), Validators.required],
    endDate: [new Date(), Validators.required]
  })

  booking: Booking = {
    id: 100,
    name: "Your Name",
    roomNumber: 1,
    startDate: new Date(),
    endDate: new Date()
  }

  ngOnInit(): void {
    if (this.router.url != '/create') {
      const id = Number(this.activatedRoute.snapshot.paramMap.get('id'));

      this.bookingService.getBookingById(id).subscribe((result) => {
        this.booking = result;
        this.bookingForm.patchValue(this.booking);
      });
    }
  }

  dateChanged(event: Event, isStart: boolean) {
    const val = (event.target as HTMLInputElement).value;
    if (isStart) {
      this.booking.startDate = new Date(val);
    } else {
      this.booking.endDate = new Date(val);
    }
  }

  save(): void {
    const formValue = this.bookingForm.value;
    const newBooking: Booking = {
      ...formValue
    };

    this.bookingService.addBooking(newBooking).subscribe();
    this.router.navigate(['bookings']);
  }
}
