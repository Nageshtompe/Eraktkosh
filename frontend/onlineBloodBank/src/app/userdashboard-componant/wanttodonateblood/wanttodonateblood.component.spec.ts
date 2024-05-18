import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WanttodonatebloodComponent } from './wanttodonateblood.component';

describe('WanttodonatebloodComponent', () => {
  let component: WanttodonatebloodComponent;
  let fixture: ComponentFixture<WanttodonatebloodComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [WanttodonatebloodComponent]
    });
    fixture = TestBed.createComponent(WanttodonatebloodComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
