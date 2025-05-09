import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TeamListingComponent } from './team-listing.component';

describe('TeamListingComponent', () => {
  let component: TeamListingComponent;
  let fixture: ComponentFixture<TeamListingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TeamListingComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TeamListingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
