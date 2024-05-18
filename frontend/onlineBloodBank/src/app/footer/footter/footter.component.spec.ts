import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FootterComponent } from './footter.component';

describe('FootterComponent', () => {
  let component: FootterComponent;
  let fixture: ComponentFixture<FootterComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FootterComponent]
    });
    fixture = TestBed.createComponent(FootterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
