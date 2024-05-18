import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LookingforbloodComponent } from './lookingforblood.component';

describe('LookingforbloodComponent', () => {
  let component: LookingforbloodComponent;
  let fixture: ComponentFixture<LookingforbloodComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [LookingforbloodComponent]
    });
    fixture = TestBed.createComponent(LookingforbloodComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
