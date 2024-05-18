import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RootdashboardComponent } from './rootdashboard.component';

describe('RootdashboardComponent', () => {
  let component: RootdashboardComponent;
  let fixture: ComponentFixture<RootdashboardComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RootdashboardComponent]
    });
    fixture = TestBed.createComponent(RootdashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
