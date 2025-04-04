import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TournamentListingComponent } from './tournament-listing.component';

describe('TournamentListingComponent', () => {
  let component: TournamentListingComponent;
  let fixture: ComponentFixture<TournamentListingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TournamentListingComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TournamentListingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
